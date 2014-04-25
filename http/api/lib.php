<?
$host = 'localhost';
$dbname = 'soundcloud';
$username = 'root'; // TODO change this to something more secure.. Something that can only access one database and not create or drop tables.
$password = 'toor'; // TODO of course change this..
try {
	$con = new PDO('mysql:host='. $host .';dbname='.$dbname, $username, $password);
	$con->setAttribute( PDO::ATTR_EMULATE_PREPARES, false );
} catch(PDOException $e) {
	print "Error!: " . $e->getMessage() . "<br/>";
    die();
}

function numOnly($n) {
	if(!ctype_digit($n))
		exitCode($n.' is not a number');
}

function responseFactory($msg) {
	$ret = array();
	$ret['success'] = true;
	$ret['message'] = $msg;
	return $ret;
}

function exitCode($msg,$success = false) {
	logger($msg);
	$res = array();
	$res['success'] = $success;
	$res['message'] = $msg;
	exit(json_encode($res));
}

function errC($stmt,$debug = false) {
	if($stmt->errorCode() != '00000') {
		$err = logger("MySQL Error: ".$stmt->errorInfo()[2]);
		if($debug)
			echo $err;
		exitCode($err);
	}
}
function logger($msg) {
	return $msg;
}
?>