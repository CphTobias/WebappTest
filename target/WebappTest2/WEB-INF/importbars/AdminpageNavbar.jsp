<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
<div class =col-md-2>
    <p></p>
</div>
<div class =col-md-6>
    <p></p>
    <h1><a class="one" href="FrontController?target=redirect&destination=adminpage">TobyCars</a></h1>
</div>
<div class =col-md-4>
    <p></p>
    <div class="btn-group" role="group" aria-label="login" style="left:20px">
        <button id="myBtn" class="btn btn-secondary">Logout</button>

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
    <p></p>
</div>
</nav>
