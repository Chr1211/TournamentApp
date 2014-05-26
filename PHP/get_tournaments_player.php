<?php

/*
 * Following code will get single player details
 * A player is identified by email
 */

// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';

// connecting to db
$db = new DB_CONNECT();

// check for post data

if (isset($_GET['email'])) {
    $email = $_GET['email'];
    
    // get a player from player table
    $result = mysql_query( "SELECT T.name, T.startDate, T.endDate, T.maxPlayers, T.variables FROM  `TournamentPlayer` TP,  `Tournament` T WHERE TP.name = T.name AND TP.email ='$email'");
   
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {
		$response["tournaments"] = array();

            while($row=mysql_fetch_array($result)) {
                $tournament=array();
		  $tournament["name"] = $row["name"];
      		  $tournament["startDate"] = $row["startDate"];
      		  $tournament["endDate"] = $row["endDate"];
 		array_push($response["tournaments"], $tournament);
            }
            
           
            $response["success"] = 1;

            
            // $response["tournaments"] = $tournament;

            

            // echoing JSON response
            echo json_encode($response);
        } else {
            // no playerfound
            $response["success"] = 0;
            $response["message"] = "No player found indeni";

            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no playerfound
        $response["success"] = 0;
        $response["message"] = $email;
		
        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}
?>