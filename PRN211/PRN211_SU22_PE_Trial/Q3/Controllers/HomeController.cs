using Microsoft.AspNetCore.Mvc;
using System.Data.SqlClient;
using Q3.Models;
using System.Data;

namespace Q3.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index(int CustomerId = 0)
        {
            var dp = new DataProvider();
            var customers = new List<Customer>();
            var contracts = new List<Contract>();

            using (var customersReader = dp.ExecuteQuery(
                @"SELECT CustomerId, CustomerName
                FROM Customer"
            ))
            {
                while (customersReader.Read())
                {
                    customers.Add(new Customer()
                    {
                        CustomerId = customersReader.GetInt32(0),
                        CustomerName = customersReader.GetString(1)
                    });
                }
            }

            IDataReader contractsReader;
            if (CustomerId == 0 )
            {
                contractsReader = dp.ExecuteQuery(
                    @"SELECT Code, CustomerName, EmployeeName, Type, SignedDate
                    FROM Contract
                    JOIN Employee
                    ON Contract.EmployeeId = Employee.EmployeeId
                    JOIN Customer
                    ON Contract.CustomerId = Customer.CustomerId"
                );
            }
            else
            {
                contractsReader = dp.ExecuteQuery(
                    @$"SELECT Code, CustomerName, EmployeeName, Type, SignedDate
                    FROM Contract
                    JOIN Employee
                    ON Contract.EmployeeId = Employee.EmployeeId
                    JOIN Customer
                    ON Contract.CustomerId = Customer.CustomerId
                    WHERE Contract.CustomerId = ${CustomerId}"
                );
            }
            using (contractsReader)
            {
                while (contractsReader.Read())
                {
                    contracts.Add(new Contract()
                    {
                        Code = contractsReader.GetString(0),
                        CustomerName = contractsReader.GetString(1),
                        EmployeeName = contractsReader.GetString(2),
                        Type = contractsReader.GetString(3),
                        SignedDate = contractsReader.GetDateTime(4)
                    });
                }
            }
            
            ViewBag.Customers = customers;
            ViewBag.Contracts = contracts;
            ViewBag.SelectedId = CustomerId;
            return View();
        }
    }
}
