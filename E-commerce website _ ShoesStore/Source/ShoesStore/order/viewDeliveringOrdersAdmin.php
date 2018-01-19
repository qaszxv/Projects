<?php 
    require "functions/config.inc.php";

    if (!empty($_SESSION['userID'])) {
        $userID = $_SESSION['userID'];
    } else {
        header("location: ");
    } 
    //To get the Ordered Date
    $selectQuery = $mysqli->query("SELECT orderID, userID, sum(quantity) as shoesQty, shoesID, orderedDate, shipmentDate FROM orders GROUP BY orderedDate HAVING shipmentDate IS NULL ORDER BY orderedDate DESC");


    while ($rows = mysqli_fetch_array($selectQuery)) {

        //Get variable to calculate
        $shoesID = $rows['shoesID'];
        $orderID = $rows['orderID'];

        $shoesQty = $rows['shoesQty'];

        $sOrderedDate = $rows['orderedDate']; 
        $sShipmentDate = $rows['shipmentDate']; 

        $userID = $rows['userID'];
        
        //Convert string to DateTime
        $orderDate = new DateTime($sOrderedDate); 
        if (!empty($sShipmentDate)) {
            $shipmentDate = new DateTime($sShipmentDate); 
            $sShipmentDate = $shipmentDate->format('d-m-Y');
        } else {
            $sShipmentDate = '...';
        }

        $totalPrice = 10; 

        //To calculate the Quatity and Total price
        $calQty = $mysqli->query("SELECT shoes.price as shoesPrice, orders.quantity as shoesQty FROM orders, shoes WHERE orders.orderedDate = '$sOrderedDate' AND shoes.shoesID = $shoesID"); 

        while ($rows2 = mysqli_fetch_array($calQty)) {
            //Get Total Price
            $totalPrice += $rows2['shoesPrice']*$rows2['shoesQty']; 
        }

        //Get subTotal
        $subTotal = $totalPrice - 10; 
?> 


        <?php 
            echo "<div class='checkout'>";
            echo "    <div class='summary'>";
            echo "<h1>ORDER CODE #".$orderID."</h1>";
            echo "<div class='left'>";
            echo "    <h2>User ID</h2>";
            echo "    <h2>Ordered Date</h2>";
            echo "    <h2>Received Date</h2>";
            echo "    <h2>Status</h2>";
            echo "    <h2>Total Qty</h2>";
            echo "    <h2>Merchandise Total</h2>";
            echo "    <h2>Shipping Fee</h2>";
            echo "    <h2 style='font-weight: bold; margin-top: 40px; margin-bottom: 20px;'>TOTAL</h2>";
            echo "</div>";
            echo "<div class='right'>";
            echo "    <h2>".$rows['userID']."</h2>";
            echo "    <h2>".$orderDate->format('d-m-Y')."</h2>";
            echo "    <h2>".$sShipmentDate."</h2>";
            if (empty($rows['shipmentDate'])) {
                echo "    <h2 style='color: red; font-weight: bold;'>DELIVERING</h2>";
            } else {
                echo "    <h2 style='color: green; font-weight: bold;'>COMPLETED</h2>";
            }
            
            echo "    <h2>".$shoesQty."</h2>";
            echo "    <h2>$".$subTotal.".00</h2>";
            echo "    <h2>$10.00</h2>";
            echo "    <h2 style='font-weight: bold; margin-top: 40px; margin-bottom: 20px;'>$".$totalPrice.".00</h2>";
            echo "    </div>";
            if (empty($rows['shipmentDate'])) {
                echo "<form action='order/delivered.php' method='POST'>";
                // echo "<input type='text' name='orderID' value='DELIVERED' style='display: none; '>";
                echo "<input type='text' name='orderedDate' value='".$rows['orderedDate']."' style='display: none;'>";
                echo "<input type='text' name='userID' value='".$userID."' style='display: none;'>";

                echo "<input type='submit' name='delivered' value='DELIVERED' style='float: right; width: 20%; height: 50px; background-color: black; color: white; border: none; font-size: 1.3em;'>";
                echo "</form>";                
            }
            echo "</div>";
            echo "</div> ";
            };
        ?>
    


<!-- HTML code for the check out outline  
<div class="checkout">
    <div class="summary">
        <h1>ORDER CODE #432</h1>
        <div class="left">
            <h2>User ID</h2>
            <h2>User Name</h2>
            <h2>Ordered Date</h2>
            <h2>Received Date</h2>
            <h2>Status</h2>
            <h2>Total Qty</h2>
            <h2>Merchandise Total</h2>
            <h2>Shipping Fee</h2>
            <h2 style="font-weight: bold; margin-top: 40px; margin-bottom: 20px;">SUBTOTAL</h2>
        </div>
        <div class="right">
            <h2>#123</h2>
            <h2>Hung Le</h2>
            <h2>2017/8/12</h2>
            <h2>...</h2>
            <h2 style="color: red; font-weight: bold;">DELIVERY</h2>
            <h2>3</h2>
            <h2>$150.00</h2>
            <h2>$10.00</h2>
            <h2 style="font-weight: bold; margin-top: 40px; margin-bottom: 20px;">$160.00</h2>
        </div>
        <form>
            <input type="submit" name="" value="DELEVERED" style="float: right; width: 20%; height: 50px; background-color: black; color: white; border: none; font-size: 1.3em;">
        </form>
    </div>
</div>
-->
