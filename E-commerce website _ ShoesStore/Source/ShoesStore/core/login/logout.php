<?php
	session_start();
	unset($_SESSION['email']);
	$_SESSION['logout-message'] = "You are now logged out";
	session_unset();
    header ("location: " . $_SERVER['HTTP_REFERER']);
?>