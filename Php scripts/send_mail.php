<?php
require("sendgrid-php/sendgrid-php.php");
$from = new SendGrid\Email("Example User", "riamaheshwari2507@gmail.com");
$subject = "---------";
$to = new SendGrid\Email("Example User", "riamaheshwari2507@gmail.com");
$content = new SendGrid\Content("text/plain", "--------------");
$mail = new SendGrid\Mail($from, $subject, $to, $content);
$apiKey = "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" ;
$sg = new \SendGrid($apiKey);
$response = $sg->client->mail()->send()->post($mail);
echo $response->statusCode();
print_r($response->headers());
echo $response->body();
?>