<div class="row" style="background-color: rgba(29,29,29,0.91);">
    <div class =col-md-1>
        <p></p>
    </div>
    <div class =col-md-4>
        <h1><a class="one" href="FrontController?target=redirect&destination=customerpage">TobyCars</a></h1>
    </div>
    <div class =col-md-7 style="text-align: right; right: 10px">
        <p></p>
        <div class="btn-group" role="group" aria-label="Main menu" style="top:6px;">
            <a class="two" href="FrontController?target=redirect&destination=customerpage">
                <button type="submit" class="btn btn-secondary">Home</button></a>
        </div>

        <div class="btn-group" role="group" aria-label="FAQ" style="top:6px;">
            <a class="two" target="_blank" href="FrontController?target=redirect&destination=FAQ">
                <button type="submit" style="left:20px" class="btn btn-secondary">FAQ</button></a>
        </div>

        <div class="btn-group" role="group" aria-label="FAQ" style="top:6px;">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="getallcars">
                <button type="submit" class="btn btn-secondary">Cars</button>
            </form>
        </div>

        <div class="btn-group" role="group" aria-label="First group" style="top:6px">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="getbasket">
                <input type="hidden" name="userid" value="${sessionScope.user.id}">
                <button type="submit" class="btn btn-secondary">Basket</button>
            </form>
        </div>

        <div class="btn-group" role="group" aria-label="login" style="top:6px;">
            <button type="button" class="btn btn-secondary">${sessionScope.user.name}: ${sessionScope.bank}$</button>
            <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
            </button>
            <div class="dropdown-menu">
                <button class="dropdown-item" style="text-align: center" href="#">Settings</button>
                <button class="dropdown-item" style="text-align: center;" href="#">Orders</button>
                <button class="dropdown-item" id="myBtn" style="text-align: center">Logout</button>
            </div>

            <div id="myModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <h4 class="form-text" style="text-align: center">Would you like to save your current order?</h4>
                    <form action="FrontController" method="post">
                        <input type="hidden" name="target" value="logoutuser">
                        <input type="hidden" name="userid" value="${sessionScope.user.id}">
                        <br>
                        <br>
                        <div style="text-align: center">
                            <button style="margin:5px;" name="logoutans" value="Yes" type="submit" class="btn btn-secondary">Yes</button>
                            <button style="margin:5px;" name="logoutans" value="No" type="submit" class="btn btn-secondary">No</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>