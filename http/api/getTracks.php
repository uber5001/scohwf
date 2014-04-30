<?php
 header('Access-Control-Allow-Origin: *');  
require_once('lib.php');
$offset = $_REQUEST['offset'];
$duration = $_REQUEST['duration'];

$sql = "SELECT * FROM `tracks` LIMIT :offset,:duration";
$stmt = $con->prepare($sql);
$stmt->bindParam(":offset",$offset,PDO::PARAM_INT);
$stmt->bindParam(":duration",$duration,PDO::PARAM_INT);
try {
	$stmt->execute();
} catch(PDOException $e) {
	print "Error!: " . $e->getMessage() . "<br/>";
    die();
}
errC($stmt);
$ret = responseFactory("Got Track listing");
$ret['tracks'] = array();
while($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
	$ret['tracks'][] = (int)$row['track'];
}
exit(json_encode($ret));
?>