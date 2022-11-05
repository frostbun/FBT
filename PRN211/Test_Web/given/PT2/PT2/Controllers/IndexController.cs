using Microsoft.AspNetCore.Mvc;
using PT2.Models;

namespace PT2.Controllers
{
    public class IndexController : Controller
    {
        public IActionResult Index(string DetailName = "", int MasterId = 0)
        {
            using var context = new PRN292_SU17_1Context();
            ViewBag.Masters = context.DummyMasters.ToList();
            if (MasterId == 0)
            {
                ViewBag.Details = context.DummyDetails.Where(d => d.DetailName.Contains(DetailName)).ToList();
            }
            else
            {
                ViewBag.Details = context.DummyDetails.Where(d => d.DetailName.Contains(DetailName) && d.MasterId == MasterId).ToList();
            }
            ViewBag.DetailName = DetailName;
            ViewBag.MasterId = MasterId;
            return View();
        }
    }
}
