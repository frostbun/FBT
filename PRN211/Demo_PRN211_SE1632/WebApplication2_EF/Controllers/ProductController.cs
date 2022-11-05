using Microsoft.AspNetCore.Mvc;
using WebApplication2_EF.Models;
    
namespace WebApplication2_EF.Controllers
{
    public class ProductController : Controller
    {
        public IActionResult Index()
        {
            using var context = new MySaleDBContext();
            var categories = context.Categories.ToList();
            var products = context.Products.ToList();
            ViewBag.Categories = categories;
            return View(products);
        }

        [HttpPost]
        public IActionResult Index(int CategoryId)
        {
            using var context = new MySaleDBContext();
            var categories = context.Categories.ToList();
            ViewBag.Categories = categories;
            List<Product> products;
            if (CategoryId != 0)
            {
                products = context.Products.Where(p => p.CategoryId == CategoryId).ToList();
            }
            else
            {
                products = context.Products.ToList();
            }
            ViewBag.SelectedID = CategoryId;
            return View(products);
        }

        public IActionResult Delete(int id)
        {
            using var context = new MySaleDBContext();
            var p = context.Products.FirstOrDefault(p => p.ProductId == id);
            Console.WriteLine(id);
            context.Products.Remove(p);
            context.SaveChanges();
            return RedirectToAction("Index");
        }

        public IActionResult Add()
        {
            using var context = new MySaleDBContext();
            var categories = context.Categories.ToList();
            ViewBag.Categories = categories;
            return View();
        }

        [HttpPost]
        public IActionResult Add(Product p)
        {
            using var context = new MySaleDBContext();
            if (ModelState.IsValid)
            {
                context.Add(p);
                context.SaveChanges();
                return RedirectToAction("Index");
            }
            else
            {
                return Add();
            }
        }

        public IActionResult Update(int id)
        {
            using var context = new MySaleDBContext();
            var categories = context.Categories.ToList();
            ViewBag.Categories = categories;
            var product = context.Products.FirstOrDefault(p => p.ProductId == id);
            return View(product);
        }

        [HttpPost]
        public IActionResult Update(Product p)
        {
            using var context = new MySaleDBContext();
            if (ModelState.IsValid)
            {
                context.Update(p);
                context.SaveChanges();
                return RedirectToAction("Index");
            }
            else
            {
                return Update(p.ProductId);
            }
        }

        public IActionResult Detail(int id)
        {
            using var context = new MySaleDBContext();
            ViewBag.Product = context.Products.FirstOrDefault(p => p.ProductId == id);
            return View();
        }
    }
}
