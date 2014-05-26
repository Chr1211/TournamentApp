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

    $response["tournaments"] = array();
    
    while ($row = mysql_fetch_array($result)) {
        // temp tournament array
        $tournament = array();
        $tournament["name"] = $row["name"];
        $tournament["startDate"] = $row["startDate"];
        $tournament["endDate"] = $row["endDate"];
	 $tournament["maxPlayers"] = $row["maxPlayers"];
        
        $sql="SELECT P.email, P.name, P.phoneNumber, P.admin, TP.gamemaster, TP.active FROM  `Player` P,  `TournamentPlayer` TP WHERE P.email = TP.email
                AND TP.name = '";
            $sql .=$row["name"];
            $sql .="'";
        
        $players = mysql_query($sql) or die(mysql_error());    
        $allPlayers=array();
        while($rowPlayer = mysql_fetch_assoc($players)) {
             $allPlayers[] = $rowPlayer;       
        }
        $tournament["players"]=$allPlayers;
        
        $sqlMatch="SELECT * FROM `Match` WHERE tournamentName ='";
        $sqlMatch.=$row["name"];
        $sqlMatch.="'";
        
        $matches=mysql_query($sqlMatch) or die(mysql_error());
        $allMatches=array();
        while($rowMatch=mysql_fetch_assoc($matches)) {
            $allMatches[]=$rowMatch;
        }
        $tournament["matches"]=$allMatches;
        
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
