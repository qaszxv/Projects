<?php 

    if (!empty($_GET['selectOrders'])) {
        $selectOrders = $_GET['selectOrders'];
        
        //echo $selectOrders;

        if ($selectOrders === 'viewAll') {
            //echo 'yes viewAll';
            include "order/viewOrderAdmin.php"; 
        } 