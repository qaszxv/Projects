<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/core.css">
    <link rel="stylesheet" type="text/css" href="css/productManaging.css">
    
    <title>South Group</title>
</head>
<body style="font-family: 'Open Sans', sans-serif;">
    <?php include "core/nav.php"; ?>

    <?php 
        if ($_SESSION['isAdmin'] == 0){
            $URL="404.php";
            echo '<META HTTP-EQUIV="refresh" content="0;URL=' . $URL . '">';
        }
    ?>

    <?php include "functions/productManaging.php"; ?>

    <?php include "core/footer.php"; ?> 
</body>
</html>