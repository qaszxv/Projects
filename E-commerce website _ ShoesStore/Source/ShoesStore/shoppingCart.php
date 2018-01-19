<!DOCTYPE html>
<html lang="en"> 
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/core.css">
    <link rel="stylesheet" type="text/css" href="css/shoppingCart.css">
    
    <title>South Group</title>
</head>
<body>
    <?php include "core/nav.php"; ?>

    <?php 
        if (!isset($_SESSION['userID'])){
            $URL="404.php";
            echo '<META HTTP-EQUIV="refresh" content="0;URL=' . $URL . '">';
        }
    ?>
    
    <?php include "cart/shoppingCart.php"; ?>

    <?php include "core/footer.php"; ?>
</body>
</html>