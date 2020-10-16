<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS START -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
    <!-- Bootstrap CSS END -->

    <title>Admin ${sessionScope.user.isRanked()}</title>

</head>
<body>

<!-- Picture and Main Menu START -->
<div class="row" style="background-color: rgba(29,29,29,0.91);">
    <div class =col-md-2>
        <p></p>
    </div>
    <div class =col-md-6>
        <h1><a class="one" href="FrontController?target=redirect&destination=adminpage">TobyCars</a></h1>
    </div>
    <div class =col-md-4>
        <p></p>
        <div class="btn-group" role="group" aria-label="login" style="top:6px; left:38px">
            <a class="two" href="FrontController?target=redirect&destination=index">
                <button type="button" class="btn btn-secondary">Logout</button></a>
        </div>
    </div>
</div>
<!-- Picture and Main Menu END -->

<!-- Title START -->
<div class="row">
    <div class="col-md-12" style="top:-21px;">
        <h1 class="hovedtitle">Admin Interface</h1>
    </div>
</div>
<!-- Title END -->

<!-- Get Admin Rank START -->
<div class="row">
    <div class="col-md-12" style="text-align: center;top:5px">

        <!-- No Rank Assigned -->
        <c:forEach var="norank" items="${sessionScope.norank}">
            <div class="btn-group" role="group" aria-label="FAQ" id="submitdiv">
                <h3>You have no admin rank. Contact a high ranked admin for help</h3>
            </div>
        </c:forEach>

        <!-- Rank 10 -->
        <c:forEach var="rank10" items="${sessionScope.rank10}">
            <div class="btn-group" role="group" aria-label="FAQ" id="submitdiv">
                <button onclick="getMessages(), myFooter()" style="left:15px" class="btn btn-secondary">Manage Messages</button>
            </div>
        </c:forEach>

        <!-- Rank 50 -->
        <c:forEach var="rank50" items="${sessionScope.rank50}">
            <div class="btn-group" role="group" aria-label="FAQ">
                <button onclick="getCars(), myFooter()" style="left:15px" class="btn btn-secondary">Manage Cars</button>
            </div>
            <div class="btn-group" role="group" aria-label="FAQ" id="submitdiv">
                <button onclick="getMessages(), myFooter()" style="left:15px" class="btn btn-secondary">Manage Messages</button>
            </div>
        </c:forEach>

        <!-- Rank 99 -->
        <c:forEach var="rank99" items="${sessionScope.rank99}">
            <div class="btn-group" role="group" aria-label="FAQ">
                <button onclick="getUsers(), myFooter()" style="left:15px" class="btn btn-secondary">Manage Users</button>
            </div>
            <div class="btn-group" role="group" aria-label="FAQ">
                <button onclick="getCars(), myFooter()" style="left:15px" class="btn btn-secondary">Manage Cars</button>
            </div>
            <div class="btn-group" role="group" aria-label="FAQ" id="submitdiv">
                <button onclick="getMessages(), myFooter()" style="left:15px" class="btn btn-secondary">Manage Messages</button>
            </div>
        </c:forEach>
    </div>
</div>
<!-- Get Admin Rank END -->

<!-- Admin Choice -->
<div class="row">
    <div class="col-md-4">

    </div>
    <div class="col-md-4">

    </div>
    <div class="col-md-4">

    </div>
</div>

<!-- Admin Dropdown Menu START -->
<div class="row">
    <div class="col-md-4">

    </div>

    <!-- Shown By Buttons.js -->
    <div class="col-md-4">
        <div id="myUSER" style="display:none">
            <br>
            <h3 class="title">User Options</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="adminoptions">
                <div class="form-group">
                    <select class="form-control" name="adminselect" id="useroptionselect">
                        <option>Show Users</option>
                        <option>Change Moderator Access</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-secondary">Submit</button>
            </form>
        </div>

        <div id="myCAR" style="display:none">
            <br>
            <h3 class="title">Car Options</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="adminoptions">
                <div class="form-group">
                    <select class="form-control" name="adminselect" id="caroptionsselect">
                        <option>Add Car</option>
                        <option>Manage Car Availability</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-secondary">Submit</button>
            </form>
        </div>

        <div id="myDIV" style="display:none">
            <br>
            <h3 class="title">Update Messages</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="adminoptions">
                <div class="form-group">
                    <select class="form-control" name="adminselect" id="myselect">
                        <option>Active Messages</option>
                        <option>Closed Messages</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-secondary">Submit</button>
            </form>
        </div>
    </div>
    <!-- Shown By Buttons.js -->

    <div class="col-md-4">

    </div>
</div>
<!-- Admin Dropdown Menu END-->

<!-- Choice From Chosen Dropdown START-->
<div class="row">
    <div class="col-md-4">

    </div>
    <div class="col-md-5">

        <!-- USERS START -->
        <!-- Show Users From START -->
        <c:forEach var="showusers" items="${requestScope.showusers}">
            <br>
            <h3 class="title">Show Users</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="showusers">
                <div class="form-group" style="top:10px">
                    <label for="userrole">Role</label>
                    <select class="form-control" name="usersrole" id="usersrole">
                        <option>customer</option>
                        <option>employee</option>
                        <option>admin</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-secondary">Update User</button>
            </form>
        </c:forEach>
        <!-- Show Users From END -->

        <!-- Show Users Chosen START -->
        <ol>
            <c:forEach var="showchosenrole" items="${requestScope.showchosenrole}">
                <div class="input-group">
                    <form action="FrontController" method="post">
                        <input type="hidden" name="target" value="userbanned">
                        <br>
                        <li><c:out value="Name: ${showchosenrole.name}"/>
                            <br><c:out value="Created at: ${showchosenrole.createdAt.toLocalDate()} ${showchosenrole.createdAt.toLocalTime()}"/>
                            <br><c:out value="Role: ${showchosenrole.role}"/>
                            <br><c:out value="Banned: ${showchosenrole.banned}"/>
                            <br><input type="hidden" id="userid" name="userid" value="${showchosenrole.id}">
                            <input type="hidden" id="userban" name="userban" value="${showchosenrole.banned}">
                            <button type="submit" class="btn btn-secondary">Ban/Unban</button>
                        </li>
                    </form>
                </div>
                <br>
            </c:forEach>
        </ol>
        <!-- Show Users Chosen END -->

        <!-- Update User Role START -->
        <c:forEach var="allusers" items="${requestScope.allusers}">
            <br>
            <h3 class="title">Update User Role</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="updateuser">
                <div class="form-group">
                    <label for="InputUserName">Username</label>
                    <input type="text" name="username" class="form-control" id="InputUserName" placeholder="Username">
                </div>
                <div class="form-group" style="top:10px">
                    <label for="userrole">Role</label>
                    <select class="form-control" name="userrole" id="userrole">
                        <option>customer</option>
                        <option>admin</option>
                    </select>
                </div>
                <div class="form-group" style="top:10px">
                    <label for="userrank">Rank Levels:
                            <br>1: Normal Customer
                            <br>10: Lowest Level Admin
                            <br>50: Medium Level Admin
                            <br>99: Max Level Admin</label>
                    <select class="form-control" name="userrank" id="userrank">
                        <option>1</option>
                        <option>10</option>
                        <option>50</option>
                        <option>99</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-secondary">Update User</button>
            </form>
        </c:forEach>
        <!-- Update User ROle END -->
        <!-- USERS END -->

        <!-- CARS START -->
        <!-- Add Car START -->
        <c:forEach var="addcars" items="${requestScope.addcar}">
            <br>
            <h3 class="title">Add Car</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="addnewcar">
                <div class="form-group">
                    <label for="InputHorsePower">Horsepower eks. "15"</label>
                    <input type="horsepower" name="horsepower" class="form-control" id="InputHorsePower" placeholder="Horsepower">
                </div>
                <div class="form-group" style="top:10px">
                    <label for="InputBrand">Brand eks. "Audi"</label>
                    <input type="brand" class="form-control" name="brand" id="InputBrand" aria-describedby="Brand" placeholder="Brand">
                </div>
                <div class="form-group" style="top:10px">
                    <label for="InputPrice">Price eks. "100000"</label>
                    <input type="price" class="form-control" name="price" id="InputPrice" aria-describedby="Price" placeholder="Price">
                </div>
                <div class="form-group">
                    <label for="InputModel">Model eks. "A6 3.0 4dr"</label>
                    <input type="model" class="form-control" name="model" id="InputModel" aria-describedby="Model" placeholder="Model">
                </div>
                <div class="form-group" style="top:10px">
                    <label for="category">Category</label>
                    <select class="form-control" name="category" id="category">
                        <option>Small</option>
                        <option>Medium</option>
                        <option>Large</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="InputWeight">Weight eks. "3561"</label>
                    <input type="weight" class="form-control" name="weight" id="InputWeight" aria-describedby="Weight" placeholder="Weight">
                </div>
                <div class="form-group">
                    <label for="InputBuildYear">Build Year eks. "2009"</label>
                    <input type="buildyear" class="form-control" name="buildyear" id="InputBuildYear" aria-describedby="BuildYear" placeholder="Build Year">
                </div>
                <div class="form-group">
                    <label for="InputMilage">Milage eks. "35995"</label>
                    <input type="milage" class="form-control" name="milage" id="InputMilage" aria-describedby="Milage" placeholder="Milage">
                </div>
                <div class="form-group">
                    <label for="InputImage">Image eks. "A6304dr.jpg"</label>
                    <input type="imagefilepath" class="form-control" name="image" id="InputImage" aria-describedby="Image" placeholder="Image Folder">
                </div>
                <button type="submit" class="btn btn-secondary">Add Car</button>
            </form>
        </c:forEach>
        <!-- Add Car END -->

        <!-- Car Available START -->
        <ol>
            <c:forEach var="available" items="${requestScope.available}">
                <div class="input-group">

                    <form action="FrontController" method="post">
                        <input type="hidden" name="target" value="caravailable">
                        <li><c:out value="Brand: ${available.brand}"/>
                            <c:out value=" - Model: ${available.model}"/>
                            <br><c:out value="Price: ${available.price}"/>
                            <br><c:out value="Available: ${available.available}"/>
                            <br><c:out value="New Price? (Leave Empty If No Change)"/>
                            <br><input type="text" name="changeprice" id="ChangePrice" aria-describedby="ChangePrice" placeholder="Change Price?">
                            <br><input type="hidden" id="carid" name="carid" value="${available.id}">
                            <input type="hidden" id="caravailable" name="caravailable" value="${available.available}">
                            <br><button type="submit" class="btn btn-secondary">Close/Open</button>
                        </li>
                    </form>
                </div>
                <br>
            </c:forEach>
        </ol>
        <!-- Car Available END -->
        <!-- CARS END -->

        <!-- CONTACT MESSAGES START -->
        <!-- Show Messages START -->
        <br>
        <ol>
            <c:forEach var="message" items="${requestScope.activeCM}">
                <div class="input-group">
                    <form action="FrontController" method="post">
                        <input type="hidden" name="target" value="messageanswered">
                        <li><c:out value="Date: ${message.createdAt.toLocalDate()}"/>
                            <c:out value=" - Time: ${message.createdAt.toLocalTime()}"/>
                            <br><c:out value="Name: ${message.name}"/>
                            <br><c:out value="Email: ${message.email}"/>
                            <br><c:out value="Message: ${message.message}"/>
                            <br><input type="hidden" id="messages" name="messages" value="${message.id}">
                            <input type="hidden" id="answered" name="answered" value="${message.answered}">
                            <br><button type="submit" class="btn btn-secondary">Close/Open</button>
                        </li>
                    </form>
                </div>
                <br>
            </c:forEach>
        </ol>
        <!-- Show Messages END -->
        <!-- CONTACT MESSAGES END -->
    </div>
    <div class="col-md-3">

    </div>
</div>
<!-- Choice From Chosen Dropdown END-->

<!-- myFooter START -->
<div class="row">
    <div class="col-md-12" style="background-color: rgba(29,29,29,0.91)">
        <!-- Gets Called on Button Click In Admin Menu START -->
        <div id="myFooter" style="display: block">
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        </div>
        <!-- Gets Called on Button Click In Admin Menu END -->
    </div>
</div>
<!-- myFooter END -->

<div class="row">
    <div class="col-md-12" style="background-color: rgba(29,29,29,0.91)">
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
    </div>
</div>

<footer class="page-footer font-small blue" style="background-color: rgba(29,29,29,0.91)">

    <!-- Copyright START -->
    <div class="footer-copyright text-center py-3"><text style="color: #ececec">© 2020 Copyright:</text>
        <a class="one" href="cars.html">Tobias og Co |</a>
        <a class="one" href="locations.html"> EliteinsaneCars |</a>
        <a class="one" href="offers.html"> Even more elite cars </a>
    </div>
    <!-- Copyright END -->

</footer>
<script type="text/javascript" src='<c:url value="/scripts/buttons.js"/>'></script>
<!-- jQuery first, then Tether, then Bootstrap JS. -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>