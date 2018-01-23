package post // Package may be different for you.

// Imports that are needed for this to work.
import (
    "bytes"
    "encoding/json"
    "fmt"
    "github.com/bwmarrin/discordgo"
    "net/http"
)

/*
 * The payload object we will be using.
 * The name and properties are lowercase as they are not needed outside of this package.
 */
type payload struct {
    serverCount int `json:"server_count"` //Indicates the JSON key name.
}

/*
 * Like the above, this is a payload.
 * This should be used if your bot is sharded.
 */
type shardPayload struct {
    serverCount int `json:"server_count"`
    shardId     int `json:"shard_id"`
    shardCount  int `json:"shard_count"`
}

/*
 * Declares the API URL and Token as constants.
 */
const (
    api   = "https://discordbots.org/api/bots/%v/stats"
    token = "DBLAPIKEY"
)

// SendServerCount sends the actual server count, takes in a pointer for the DiscordGo object.
func SendServerCount(session *discordgo.Session) {
    botID := session.State.User.ID // Gets the bot ID, presuming DGo is running a bot.
    url := fmt.Sprintf(api, botID)
    // This creates a payload. Use the sharded version if you need to.
    payload := payload{
        serverCount: len(session.State.Guilds),
    }
    body, err := json.Marshal(payload)
    if err != nil {
        panic(err) // I panic here, you can handle the error how you want.
    }
    request, err := http.NewRequest("POST", url, bytes.NewBuffer(body))
    if err != nil {
        panic(err) // Again, handle it how you want.
    }
    request.Header.Set("Content-Type", "application/json")
    request.Header.Set("Authorization", token)
    client := &http.Client{}
    _, err = client.Do(request)
    if err != nil {
        panic(err) // Or add your own handler.
    }
}
