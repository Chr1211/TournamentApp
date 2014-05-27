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
if (isset($_GET["email"]) && isset($_GET["password"])) {
    $email = $_GET['email'];
    $password = $_GET['password'];

    // get a player from player table
    $result = mysql_query("SELECT * FROM Player WHERE email = $email AND password=$password");

    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {

            $result = mysql_fetch_array($result);

            $player= array();
            $player["email"] = $result["email"];
            $player["name"] = $result["name"];
            $player["phoneNumber"] = $result["phoneNumber"];
            $player["password"] = $result["password"];
            $player["admin"] = $result["admin"];
            // success
            $response["success"] = 1;

            // user node
            $response["player"] = array();

            array_push($response["player"], $player);

            // echoing JSON response
            echo json_encode($response);
        } else {
            // no player found
            $response["success"] = 0;
            $response["message"] = "No player found";

            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no player found
        $response["success"] = 0;
        $response["message"] = "No player found";

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