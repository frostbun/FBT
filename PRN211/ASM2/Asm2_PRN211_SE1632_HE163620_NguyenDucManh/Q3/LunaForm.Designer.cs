namespace Q3
{
    partial class LunaForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tbResult = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.btExit = new System.Windows.Forms.Button();
            this.btCalc = new System.Windows.Forms.Button();
            this.nmYear = new System.Windows.Forms.NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)(this.nmYear)).BeginInit();
            this.SuspendLayout();
            // 
            // tbResult
            // 
            this.tbResult.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbResult.Location = new System.Drawing.Point(432, 205);
            this.tbResult.Name = "tbResult";
            this.tbResult.ReadOnly = true;
            this.tbResult.Size = new System.Drawing.Size(158, 35);
            this.tbResult.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(151, 45);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(493, 30);
            this.label1.TabIndex = 2;
            this.label1.Text = "Chương trình đổi năm dương lịch sang năm âm lịch";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(189, 136);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(168, 30);
            this.label2.TabIndex = 3;
            this.label2.Text = "Năm dương lịch:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label3.Location = new System.Drawing.Point(201, 210);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(136, 30);
            this.label3.TabIndex = 4;
            this.label3.Text = "Năm âm lịch:";
            // 
            // btExit
            // 
            this.btExit.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btExit.Location = new System.Drawing.Point(213, 306);
            this.btExit.Name = "btExit";
            this.btExit.Size = new System.Drawing.Size(109, 44);
            this.btExit.TabIndex = 5;
            this.btExit.Text = "Thoát";
            this.btExit.UseVisualStyleBackColor = true;
            this.btExit.Click += new System.EventHandler(this.btExit_Click);
            // 
            // btCalc
            // 
            this.btCalc.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btCalc.Location = new System.Drawing.Point(454, 306);
            this.btCalc.Name = "btCalc";
            this.btCalc.Size = new System.Drawing.Size(109, 44);
            this.btCalc.TabIndex = 6;
            this.btCalc.Text = "Xem";
            this.btCalc.UseVisualStyleBackColor = true;
            this.btCalc.Click += new System.EventHandler(this.btCalc_Click);
            // 
            // nmYear
            // 
            this.nmYear.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.nmYear.Location = new System.Drawing.Point(432, 131);
            this.nmYear.Maximum = new decimal(new int[] {
            9999,
            0,
            0,
            0});
            this.nmYear.Name = "nmYear";
            this.nmYear.Size = new System.Drawing.Size(158, 35);
            this.nmYear.TabIndex = 7;
            // 
            // LunaForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.nmYear);
            this.Controls.Add(this.btCalc);
            this.Controls.Add(this.btExit);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.tbResult);
            this.Name = "LunaForm";
            this.Text = "LunaForm";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.LunaForm_FormClosing);
            ((System.ComponentModel.ISupportInitialize)(this.nmYear)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private TextBox tbResult;
        private Label label1;
        private Label label2;
        private Label label3;
        private Button btExit;
        private Button btCalc;
        private NumericUpDown nmYear;
    }
}