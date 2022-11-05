using Microsoft.AspNetCore.Mvc;
using WebAppMVC.Models;
namespace WebAppMVC.Controllers
{
    public class HomeController : Controller
    {
        //action trong controller
        public IActionResult Index(Student student)
        {
            //truyen du lieu
            //c1 view data
            ViewData["Message"] = "Day la cach su dung ViewData";
            ViewData["Data"] = new Student
            {
                Code = "sv01",
                Name = "Nguyen Van A",
                Mark = 10
            };
            //c2 viewBa
            ViewBag.Message1 = "Day la cach dung view bag";
            ViewBag.Data1 = student;
            //ViewBag.Data1 = new Student("Sv01", "Nguyen Van b", 8);
            //c3 model
            //Student student = new Student();
            //student.Code = "sv01";
            //student.Name = "nhuyen avn c";
            //student.Mark = 7;



            return View(student);
        }

        public IActionResult Add()
        {
            return View();
        }

        static List<Student> list = new List<Student>();

        [HttpPost]
        public IActionResult Add(Student student)
        {
            if (ModelState.IsValid)
            {
                list.Add(student);
                ViewBag.Data = list;
                return View("ListStudent", student);
            }


            return View();
        }
        public IActionResult Detail(string id)
        {
            Student student = list.FirstOrDefault(item => item.Code == id);
            return RedirectToAction("Index", student);
        }

        public IActionResult Update(string id)
        {
            Student student = list.FirstOrDefault(item => item.Code == id);
            return View( student);
        }

        public IActionResult Delete(string id)
        {
            Student student = list.FirstOrDefault(item => item.Code == id);
            list.Remove(student);
            ViewBag.Data = list;
            return View("ListStudent", student);
        }

        [HttpPost]
        public IActionResult Update(Student student)
        {
            if (ModelState.IsValid)
            {
                string id = student.Code;
                Student student2 = list.FirstOrDefault(item => item.Code == id);
                student2.Name = student.Name;
                student2.Mark = student.Mark;
                ViewBag.Data = list;
                return View("ListStudent", student2);
            }


            return View();
        }
    }
}
