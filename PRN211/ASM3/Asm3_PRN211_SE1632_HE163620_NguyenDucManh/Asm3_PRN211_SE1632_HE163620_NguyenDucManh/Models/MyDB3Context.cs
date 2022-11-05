using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace Asm3_PRN211_SE1632_HE163620_NguyenDucManh.Models
{
    public partial class MyDB3Context : DbContext
    {
        public MyDB3Context()
        {
        }

        public MyDB3Context(DbContextOptions<MyDB3Context> options)
            : base(options)
        {
        }

        public virtual DbSet<Customer> Customers { get; set; } = null!;
        public virtual DbSet<Product> Products { get; set; } = null!;

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            var config = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json", true, true)
                .Build();
            optionsBuilder.UseSqlServer(config.GetConnectionString("MyDB3"));
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Customer>(entity =>
            {
                entity.HasKey(e => e.CustomerCode);

                entity.Property(e => e.CustomerCode)
                    .HasMaxLength(10)
                    .IsUnicode(false);

                entity.Property(e => e.Address).HasMaxLength(50);

                entity.Property(e => e.CustomerName).HasMaxLength(50);

                entity.Property(e => e.Dob)
                    .HasColumnType("datetime")
                    .HasColumnName("DOB");
            });

            modelBuilder.Entity<Product>(entity =>
            {
                entity.HasKey(e => e.ProductCode);

                entity.Property(e => e.ProductCode)
                    .HasMaxLength(10)
                    .IsUnicode(false);

                entity.Property(e => e.Image).HasMaxLength(50);

                entity.Property(e => e.ProductName).HasMaxLength(50);

                entity.Property(e => e.Unit)
                    .HasMaxLength(50)
                    .IsUnicode(false);
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
