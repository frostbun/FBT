using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            // ViewData
            ViewData["Message"] = "ViewData";
            ViewData["Data"] = new Student("S001", "Nguyen Van A", 8);
            return View();
        }
    }
}
