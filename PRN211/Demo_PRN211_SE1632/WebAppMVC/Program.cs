var builder = WebApplication.CreateBuilder(args);



//Add
builder.Services.AddControllersWithViews();

//edit

var app = builder.Build();
app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}"
    ) ;
//app.MapGet("/", () => "Hello World!");

app.Run();
