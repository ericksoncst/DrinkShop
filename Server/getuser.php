<?php 

    require_once 'db_functions.php';
    $db = new DB_Functions();

    $response = array();
    if (isset($_POST["phone"])) {

        $phone = $_POST["phone"];

        
        $user = $db->getUserInformation($phone);

        if ($user) {
            $response["phone"] = $user["phone"];
            $response["name"] = $user["name"];
            $response["birthdate"] = $user["birthdate"];
            $response["address"] = $user["address"];
            $response["avatarUrl"] = $user["avatarUrl"];
            echo json_encode($response);
        } else {
            $response["error_msg"] = "User not found";
            echo json_encode($response);
        }
        
    } else {
        $response["error_msg"] = "Required parameter (phone) is missing!"; 
        echo json_encode($response);
    }

?>