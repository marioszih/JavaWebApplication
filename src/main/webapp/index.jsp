<!DOCTYPE html>
<html>
<head>
    <title>Index Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
    <style>
        .table {
            table-layout: auto;
            width: auto;
            margin: 0 auto;
        }
        
        th, td {
            text-align: center;
            width: auto;
        }
        
        th a {
            display: block;
            max-width: 200px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Welcome to the Index Page</h1>
        <table class="table table-bordered table-striped">
               <tr>
                   <th><a href="/JavaWebApp/register">Go to Register Page</a></th>
               </tr>
               <tr>
                   <th><a href="/JavaWebApp/display">Display all users</a></th>
               </tr>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"></script>
</body>
</html>
