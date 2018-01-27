private static final OkHttpClient client = new OkHttpClient();
    
    public static void updateServerCount(DiscordApi api) {
        String token = "Your Token goes here";
        String botId = "Your BotID goes here";

        int serverCount = api.getServers().size();

        JSONObject count = new JSONObject()
                .put("server_count", serverCount);

        try {
            client.newCall(new Request.Builder()
                    .url("https://discordbots.org/api/bots/" + botId + "/stats")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", token)
                    .post(RequestBody.create(MediaType.parse("application/json"), count.toString()))
                    .build()
            ).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
