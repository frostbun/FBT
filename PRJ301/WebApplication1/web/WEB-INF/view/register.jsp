<%@ include file="header.jsp" %>

<div class="container m-0">
  <div class="row vw-100 vh-100 text-center">
    <div class="col-md-6 row m-0 align-items-center login-form-bg-left">
      <div class="login-form-link">
        <p class="h4">Already have an account?</p>
        <a class="btn btn-secondary" href="./login.jsp">&lt;-- Login here</a>
      </div>
    </div>
    <div class="col-md-6 row m-0 align-items-center">
      <form class="login-form" action="PLACEHOLDER" method="post">
        <h1>Register</h1>
        <div class="form-floating m-3">
          <input class="form-control" type="text" name="username" id="username" placeholder="Username" value="${username}" required>
          <label class="form-label" for="username">Username</label>
        </div>
        <div class="form-floating m-3">
          <input class="form-control" type="password" name="password" id="password" placeholder="Password" required>
          <label for="password">Password</label>
        </div>
        <div class="form-floating m-3">
          <input class="form-control" type="password" name="re-password" id="re-password" placeholder="Confirm password" required>
          <label for="re-password">Confirm password</label>
        </div>
        <p class="text-danger">${error}</p>
        <button class="btn btn-primary">Register</button>
      </form>
    </div>
  </div>
</div>

<%@ include file="footer.jsp" %>
