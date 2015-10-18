<html>
<body>
    <h2>Dynamic trust web service</h2>
    <p><b>Retrieve product static rating</b>: http://default-environment-z2wpgese8j.elasticbeanstalk.com/trustservice/products/{productId}</a>
    <p><b>Retrieve buyer's friends' dynamic rating to a product</b>: http://default-environment-z2wpgese8j.elasticbeanstalk.com/trustservice/buyers/{buyerId}/{productId}</a>
    <p><b>Retrieve seller's penalty</b>: http://default-environment-z2wpgese8j.elasticbeanstalk.com/trustservice/sellers/{sellerId}</a>
    <p><b>Retrieve dynamic trust</b>: http://default-environment-z2wpgese8j.elasticbeanstalk.com/trustservice/dynamictrust/{buyerId}/{productId}/{sellerId}</a>
    <p>If any of product, buyer or seller does not exist, the retrieved value would be -1
</body>
</html>
