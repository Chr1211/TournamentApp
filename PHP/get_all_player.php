<?php

/*
 * Following code will list all the players
 */

// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';

// connecting to db
$db = new DB_CONNECT();

// get all players from players table
$result = mysql_query("SELECT * FROM Player") or die(mysql_error());

// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // players node
    $response["players"] = array();
    
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $player = array();
        $player["email"] = $row["email"];
        $player["name"] = $row["name"];
        $player["phoneNumber"] = $row["phoneNumber"];
        $player["password"] = $row["password"];
        $player["admin"] = $row["admin"];




        // push single player into final response array
        array_push($response["players"], $player);
    }
    // success
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
} else {
    // no players found
    $response["success"] = 0;
    $response["message"] = "No players found";

    // echo no users JSON
    echo json_encode($response);
}
?>
