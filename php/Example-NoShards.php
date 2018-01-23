<?php

// Note: This makes use of CURL and does not use a Discord API library so requires manual filling in of guild count and bot ID.

$GUILDCOUNT = 10; // Change Me
$BOTID = "DISCORDBOTID"; // Change Me
$AUTH = "DBLAPIKEY"; // Change Me

$dblData = Array("server_count"=>$GUILDCOUNT);
$dblData = json_encode($dblData);
$dblURL = "https://discordbots.org/api/bots/".$BOTID."/stats";

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $dblURL);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $dblData);
curl_setopt($ch, CURLOPT_HTTPHEADER, Array(
    'Authorization: '.$AUTH,
    'Content-Type: application/json'
));
$result = curl_exec($ch);
curl_close($ch);

?>
