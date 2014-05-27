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

if (isset($_GET['name'])) {
    $name = $_GET['name'];
    
    
    
    
    // get matches in a tournament from tournament name
    $result = mysql_query( "SELECT P1.MatchNumber, P1.emailWinner, P1.name as p1Name, P2.name as p2Name, P1.dato FROM (SELECT M.`MatchNumber` , M.`emailWinner`, P.name, M.`dato` FROM  `Match` M,  `Player` P WHERE P.email = M.`player1Email` AND M.tournamentName ='$name') AS P1 INNER JOIN (SELECT M.`MatchNumber` , P.name FROM  `Match` M,  `Player` P WHERE P.email = M.`player2Email` AND M.tournamentName ='$name') AS P2 ON P2.MatchNumber = P1.MatchNumber");
    
    
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {
		$response["matches"] = array();

            while($row=mysql_fetch_array($result)) {
                $matches=array();
		  $matches["p1Name"] = $row["p1Name"];
      		  $matches["p2Name"] = $row["p2Name"];
      		  $matches["dato"] = $row["dato"];
		  $matches["MatchNumber"] = $row["MatchNumber"];

		  $winner = $row["emailWinner"];
		$nameResult = mysql_query ("SELECT name FROM  `Player` WHERE  `email` LIKE  '$winner'");
		$nameRow = mysql_fetch_array($nameResult);
		$matches["winner"] = $nameRow["name"];
 		array_push($response["matches"], $matches);
            }
            
           
            $response["success"] = 1;

            // echoing JSON response
            echo json_encode($response);
        } else {
            // no playerfound
            $response["success"] = 0;
            $response["message"] = "No match found";

            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no match found
        $response["success"] = 0;
        $response["message"] = No match found;
		
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