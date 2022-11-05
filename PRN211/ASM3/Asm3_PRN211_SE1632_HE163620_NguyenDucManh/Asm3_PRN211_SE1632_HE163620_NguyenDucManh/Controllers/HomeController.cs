using Asm3_PRN211_SE1632_HE163620_NguyenDucManh.Models;
using Microsoft.AspNetCore.Mvc;

namespace Asm3_PRN211_SE1632_HE163620_NguyenDucManh.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index(string ProductCode = null!, string ProductName = "", string Image ="")
        {
            using var ctx = new MyDB3Context();
            var selectedProduct = ctx.Products.FirstOrDefault(p => p.ProductCode == ProductCode);
            var products = ctx.Products.Where(p => p.ProductName.Contains(ProductName) && p.Image.Contains(Image)).ToList();
            ViewBag.Products = products;
            return View(selectedProduct);
        }

        [HttpPost]
        public IActionResult Index(Product product)
        {
            using var ctx = new MyDB3Context();
            ctx.Update(product);
            ctx.SaveChanges();
            var products = ctx.Products.ToList();
            ViewBag.Products = products;
            return View(product);
        }
    }
}
