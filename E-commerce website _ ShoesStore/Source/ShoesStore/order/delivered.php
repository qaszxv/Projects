<?php 
    require "../functions/config.inc.php";

    if (isset($_POST['delivered'])) {
        //Get variable
        $orderedDate = $_POST['orderedDate']; 
        $userID = $_POST['userID']; 

        echo $orderedDate;
        echo $userID;


        //Get clicked time
        $time = date("Y-m-d H:i:s");
        
        $query = $mysqli->query("UPDATE orders SET orders.shipmentDate = '$time' WHERE orders.orderedDate = '$orderedDate' AND orders.userID = $userID"); 

        if (!$query) {
            trigger_error('Invalid query: ' . $mysqli->error);
        }

        header("location: " . $_SERVER['HTTP_REFERER']);
    }
?>