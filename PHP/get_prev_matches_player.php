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
    
    
    
    // get a future matches for player
    $result = mysql_query("SELECT * FROM  `Match` WHERE  (`player1Email` ='$email' OR  `player2Email` =  '$email') AND done =1");
    
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {
		$response["matches"] = array();

            while($row=mysql_fetch_array($result)) {
                $matches=array();
                
                $matches["tournamentName"] = $row["tournamentName"];
                $matches["dato"]=$row["dato"];

                
		$email1 = $row["player1Email"];
      		$email2 = $row["player2Email"];
                
                
                $name1 = mysql_query("SELECT name FROM  `Player` WHERE  `email` like '$email1'");
                $name1Row=mysql_fetch_array($name1);
                $matches["nameP1"]=$name1Row["name"];
      		
                $name2 = mysql_query("SELECT name FROM  `Player` WHERE  `email` like '$email2'");
                $name2Row=mysql_fetch_array($name2);
                $matches["nameP2"]=$name2Row["name"];
                
                
                
                array_push($response["matches"], $matches);
            }
            
           
            $response["success"] = 1;           

            // echoing JSON response
            echo json_encode($response);
        } else {
            // no match found
            $response["success"] = 0;
            $response["message"] = "No match found";

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