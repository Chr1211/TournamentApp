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

// get all tournaments from Tournament table
$result = mysql_query("SELECT * FROM Tournament") or die(mysql_error());

// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // players node
    $response["tournaments"] = array();
    
    while ($row = mysql_fetch_array($result)) {
        // temp tournament array
        $tournament = array();
        $tournament["name"] = $row["name"];
        $tournament["startDate"] = $row["startDate"];
        $tournament["endDate"] = $row["endDate"];
        $players = mysql_query("SELECT * FROM Player") or die(mysql_error());    
        $allPlayers=array();
        while($rowPlayer = mysql_fetch_array($players)) {
            $player= array();
            $player["name"] = $rowPlayer["name"];
            $player["email"] = $rowPlayer["email"];
            $player["phoneNumber"] = $rowPlayer["phoneNumber"];
            $player["password"] = $rowPlayer["password"];
            $player["admin"] = $rowPlayer["admin"];
            
            array_push($response["allPlayers"], $player);
        } 
        $tournament["players"]=$player;
      
        // push single player into final response array
        array_push($response["tournaments"], $tournament);
    }
    // success
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
} else {
    // no players found
    $response["success"] = 0;
    $response["message"] = "No tournaments found";

    // echo no users JSON
    echo json_encode($response);
}
?>
