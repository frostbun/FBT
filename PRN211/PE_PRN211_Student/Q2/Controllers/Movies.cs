using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Q2.Models;

namespace Q2.Controllers
{
    [Route("/Movies/Director_Movies")]
    public class Movies : Controller
    {
        public IActionResult Director_Movies(int id = 0)
        {
            using (var ctx = new PE_PRN_Fall22B1Context())
            {
                var selectedDirector = ctx.Directors.FirstOrDefault(d => d.Id == id);
                var directors = ctx.Directors.ToList();
                List<Movie> movies;
                if (selectedDirector is null)
                {
                    movies = ctx.Movies.Include(m => m.Producer).Include(m => m.Genres).ToList();
                }
                else
                {
                    movies = ctx.Movies.Where(m => m.DirectorId == selectedDirector.Id).Include(m => m.Producer).Include(m => m.Genres).ToList();
                }
                ViewBag.SelectedDirector = selectedDirector;
                ViewBag.Directors = directors;
                ViewBag.Movies = movies;
                return View();
            }
        }

        //public IActionResult Remove(int directorId, int movieId, int genreId)
        //{
        //    using (var ctx = new PE_PRN_Fall22B1Context())
        //    {
        //        var movie = ctx.Movies.FirstOrDefault(m => m.Id == movieId);
        //        var genre = ctx.Genres.FirstOrDefault(g => g.Id == genreId);
        //        Console.WriteLine(movie);
        //        Console.WriteLine(genre);
        //        if (movie != null && genre != null)
        //        {
        //            movie.Genres.Remove(genre);
        //            genre.Movies.Remove(movie);
        //        }
        //        int a =ctx.SaveChanges();
        //        return RedirectToAction("Director_Movies", directorId);
        //    }
        //}
    }
}
