<!DOCTYPE html>
<html>
    <head>
        <title>Ping-demo</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <style media="screen" type="text/css">
            body {
                padding: 0;
                margin: 0;
            }

            table {
                border-spacing: 0px 10px;
                width: 100%;
                border: 0;
            }

            td, th, h3, body {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                color: #444444;
                font-size: 40px;
            }

            h3 {
                font-size: 50px;
                color: #FFFFFF;
            }

            .header {
                background-color: #e88200;
                layer-background-color:layer-background-colo #e88200;
                padding-top: 0px;
                padding-bottom: 0px;
            }

            .headerTitle {
                padding: 1px 1px 0 1px;
                text-align: center;
            }
            img {
                height: 200px;
            }
        </style>
    </head>
    <body>
        <div>
            <div class="header">
                <div class="headerTitle">
                    <table>
                        <tr>
                            <td width=20></td>
                            <td width=320>
                                <img src="http://www.mmwb.nl/wp-content/uploads/2014/10/ordina-logo-455x300.jpg?81fc35" alt="ordina" />
                            </td>
                            <td>
                                <h3>Sample web-page</h3>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <br>
            Sample web-page hosted on server <?php echo $_SERVER['SERVER_ADDR']; ?>
        </div>
        <script>
            $(document).ready(function () {
                setInterval(function () {
                    cache_clear();
                }, 1000);
            });

            function cache_clear() {
                window.location.reload(true);
            }
        </script>
    </body>
</html>
