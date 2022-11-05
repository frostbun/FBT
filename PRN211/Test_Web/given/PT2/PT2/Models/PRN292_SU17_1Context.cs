using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace PT2.Models
{
    public partial class PRN292_SU17_1Context : DbContext
    {
        public PRN292_SU17_1Context()
        {
        }

        public PRN292_SU17_1Context(DbContextOptions<PRN292_SU17_1Context> options)
            : base(options)
        {
        }

        public virtual DbSet<DummyDetail> DummyDetails { get; set; } = null!;
        public virtual DbSet<DummyMaster> DummyMasters { get; set; } = null!;

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            var config = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json", true, true)
                .Build();
            optionsBuilder.UseSqlServer(config.GetConnectionString("PRN292_SU17_1"));
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<DummyDetail>(entity =>
            {
                entity.HasKey(e => e.DetailId);

                entity.ToTable("DummyDetail");

                entity.Property(e => e.DetailId)
                    .ValueGeneratedNever()
                    .HasColumnName("detail_id");

                entity.Property(e => e.DetailName)
                    .HasMaxLength(150)
                    .IsUnicode(false)
                    .HasColumnName("detail_name");

                entity.Property(e => e.MasterId).HasColumnName("master_id");

                entity.HasOne(d => d.Master)
                    .WithMany(p => p.DummyDetails)
                    .HasForeignKey(d => d.MasterId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_DummyDetail_DummyMaster");
            });

            modelBuilder.Entity<DummyMaster>(entity =>
            {
                entity.HasKey(e => e.MasterId);

                entity.ToTable("DummyMaster");

                entity.Property(e => e.MasterId)
                    .ValueGeneratedNever()
                    .HasColumnName("master_id");

                entity.Property(e => e.MasterName)
                    .HasMaxLength(150)
                    .IsUnicode(false)
                    .HasColumnName("master_name");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
