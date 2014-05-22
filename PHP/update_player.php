<?php

/*
 * Following code will update a player information
 * A product is identified by email
 */

// array for JSON response
$response = array();

// check for required fields
if (isset($_POST['email']) && isset($_POST['name']) && isset($_POST['phoneNumber']) && isset($_POST['admin'])) {
    
    $email = $_POST['email'];
    $name = $_POST['name'];
    $phoneNumber = $_POST['phoneNumber'];
    $admin = $_POST['admin'];

    // include db connect class
    require_once __DIR__ . '/db_connect.php';

    // connecting to db
    $db = new DB_CONNECT();

    // mysql update row with matched email
    $result = mysql_query("UPDATE player SET name = '$name', phoneNumber = '$phoneNumber', admin = '$admin' WHERE email = $email");

    // check if row inserted or not
    if ($result) {
        // successfully updated
        $response["success"] = 1;
        $response["message"] = "Player successfully updated.";
        
        // echoing JSON response
        echo json_encode($response);
    } else {
        
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}
?>
