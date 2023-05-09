using Microsoft.AspNetCore.Mvc;
using System.Data;
using System.Runtime.Intrinsics.Arm;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class HomeController : Controller
    {        
        public IActionResult Index(int id = 1, string? answer = null)
        {
            var dp = new DataProvider();
            IDataReader reader;
            using (reader = dp.ExecuteQuery("SELECT * FROM Questions WHERE Id = " + id))
            {
                if (reader.Read())
                {
                    var question = new Question
                    {
                        Id = reader.GetInt32(0),
                        Title = reader.GetString(1),
                        A = reader.GetString(2),
                        B = reader.GetString(3),
                        C = reader.GetString(4),
                        D = reader.GetString(5),
                        Answer = reader.GetString(6)
                    };
                    ViewBag.Question = question;
                }
            }
            using (reader = dp.ExecuteQuery("SELECT * FROM Questions WHERE Id = " + (id + 1)))
            {
                if (reader.Read())
                {
                    ViewBag.NextId = id + 1;
                }
            }
            return View();
        }

        public IActionResult Submit()
        {
            return View();
        }
    }
}
