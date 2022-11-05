namespace FinalProject
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.calendar = new System.Windows.Forms.MonthCalendar();
            this.dgEvents = new System.Windows.Forms.DataGridView();
            this.label1 = new System.Windows.Forms.Label();
            this.txtEventName = new System.Windows.Forms.TextBox();
            this.dgNotis = new System.Windows.Forms.DataGridView();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.tpEventTime = new System.Windows.Forms.DateTimePicker();
            this.label5 = new System.Windows.Forms.Label();
            this.nmDays = new System.Windows.Forms.NumericUpDown();
            this.nmHours = new System.Windows.Forms.NumericUpDown();
            this.nmMinutes = new System.Windows.Forms.NumericUpDown();
            this.label7 = new System.Windows.Forms.Label();
            this.btnEventAdd = new System.Windows.Forms.Button();
            this.btnEventUpdate = new System.Windows.Forms.Button();
            this.btnEventDelete = new System.Windows.Forms.Button();
            this.btnNotiDelete = new System.Windows.Forms.Button();
            this.btnNotiUpdate = new System.Windows.Forms.Button();
            this.btnNotiAdd = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.rbtnRepeatTypeMonthly = new System.Windows.Forms.RadioButton();
            this.rbtnRepeatTypeAnnually = new System.Windows.Forms.RadioButton();
            this.rbtnRepeatTypeNo = new System.Windows.Forms.RadioButton();
            this.label6 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.timer = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.dgEvents)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgNotis)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nmDays)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nmHours)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nmMinutes)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // calendar
            // 
            this.calendar.CalendarDimensions = new System.Drawing.Size(2, 1);
            this.calendar.Location = new System.Drawing.Point(108, 18);
            this.calendar.MaxSelectionCount = 1;
            this.calendar.Name = "calendar";
            this.calendar.TabIndex = 0;
            this.calendar.DateSelected += new System.Windows.Forms.DateRangeEventHandler(this.calendar_DateSelected);
            // 
            // dgEvents
            // 
            this.dgEvents.AllowUserToAddRows = false;
            this.dgEvents.AllowUserToDeleteRows = false;
            this.dgEvents.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgEvents.Location = new System.Drawing.Point(27, 150);
            this.dgEvents.Name = "dgEvents";
            this.dgEvents.ReadOnly = true;
            this.dgEvents.RowTemplate.Height = 25;
            this.dgEvents.Size = new System.Drawing.Size(240, 150);
            this.dgEvents.TabIndex = 1;
            this.dgEvents.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgEvents_CellClick);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(31, 61);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(69, 15);
            this.label1.TabIndex = 2;
            this.label1.Text = "Event name";
            // 
            // txtEventName
            // 
            this.txtEventName.Location = new System.Drawing.Point(106, 58);
            this.txtEventName.Name = "txtEventName";
            this.txtEventName.Size = new System.Drawing.Size(152, 23);
            this.txtEventName.TabIndex = 3;
            // 
            // dgNotis
            // 
            this.dgNotis.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgNotis.Location = new System.Drawing.Point(28, 150);
            this.dgNotis.Name = "dgNotis";
            this.dgNotis.RowTemplate.Height = 25;
            this.dgNotis.Size = new System.Drawing.Size(240, 150);
            this.dgNotis.TabIndex = 4;
            this.dgNotis.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgNotis_CellClick);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(130, 38);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(40, 15);
            this.label2.TabIndex = 5;
            this.label2.Text = "Day(s)";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(213, 38);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(47, 15);
            this.label3.TabIndex = 7;
            this.label3.Text = "Hour(s)";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(130, 77);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(127, 15);
            this.label4.TabIndex = 9;
            this.label4.Text = "Minute(s) before event";
            // 
            // tpEventTime
            // 
            this.tpEventTime.CustomFormat = "";
            this.tpEventTime.Format = System.Windows.Forms.DateTimePickerFormat.Time;
            this.tpEventTime.Location = new System.Drawing.Point(107, 29);
            this.tpEventTime.Name = "tpEventTime";
            this.tpEventTime.ShowUpDown = true;
            this.tpEventTime.Size = new System.Drawing.Size(152, 23);
            this.tpEventTime.TabIndex = 11;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(19, 40);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(60, 15);
            this.label5.TabIndex = 12;
            this.label5.Text = "Notify me";
            // 
            // nmDays
            // 
            this.nmDays.Location = new System.Drawing.Point(85, 36);
            this.nmDays.Maximum = new decimal(new int[] {
            364,
            0,
            0,
            0});
            this.nmDays.Name = "nmDays";
            this.nmDays.Size = new System.Drawing.Size(39, 23);
            this.nmDays.TabIndex = 13;
            // 
            // nmHours
            // 
            this.nmHours.Location = new System.Drawing.Point(168, 35);
            this.nmHours.Maximum = new decimal(new int[] {
            23,
            0,
            0,
            0});
            this.nmHours.Name = "nmHours";
            this.nmHours.Size = new System.Drawing.Size(39, 23);
            this.nmHours.TabIndex = 14;
            // 
            // nmMinutes
            // 
            this.nmMinutes.Location = new System.Drawing.Point(85, 74);
            this.nmMinutes.Maximum = new decimal(new int[] {
            59,
            0,
            0,
            0});
            this.nmMinutes.Name = "nmMinutes";
            this.nmMinutes.Size = new System.Drawing.Size(39, 23);
            this.nmMinutes.TabIndex = 15;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(31, 35);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(33, 15);
            this.label7.TabIndex = 17;
            this.label7.Text = "Time";
            // 
            // btnEventAdd
            // 
            this.btnEventAdd.Location = new System.Drawing.Point(35, 121);
            this.btnEventAdd.Name = "btnEventAdd";
            this.btnEventAdd.Size = new System.Drawing.Size(75, 23);
            this.btnEventAdd.TabIndex = 18;
            this.btnEventAdd.Text = "Add";
            this.btnEventAdd.UseVisualStyleBackColor = true;
            this.btnEventAdd.Click += new System.EventHandler(this.btnEventAdd_Click);
            // 
            // btnEventUpdate
            // 
            this.btnEventUpdate.Location = new System.Drawing.Point(111, 121);
            this.btnEventUpdate.Name = "btnEventUpdate";
            this.btnEventUpdate.Size = new System.Drawing.Size(75, 23);
            this.btnEventUpdate.TabIndex = 19;
            this.btnEventUpdate.Text = "Update";
            this.btnEventUpdate.UseVisualStyleBackColor = true;
            this.btnEventUpdate.Click += new System.EventHandler(this.btnEventUpdate_Click);
            // 
            // btnEventDelete
            // 
            this.btnEventDelete.Location = new System.Drawing.Point(187, 121);
            this.btnEventDelete.Name = "btnEventDelete";
            this.btnEventDelete.Size = new System.Drawing.Size(75, 23);
            this.btnEventDelete.TabIndex = 20;
            this.btnEventDelete.Text = "Delete";
            this.btnEventDelete.UseVisualStyleBackColor = true;
            this.btnEventDelete.Click += new System.EventHandler(this.btnEventDelete_Click);
            // 
            // btnNotiDelete
            // 
            this.btnNotiDelete.Location = new System.Drawing.Point(189, 121);
            this.btnNotiDelete.Name = "btnNotiDelete";
            this.btnNotiDelete.Size = new System.Drawing.Size(75, 23);
            this.btnNotiDelete.TabIndex = 23;
            this.btnNotiDelete.Text = "Delete";
            this.btnNotiDelete.UseVisualStyleBackColor = true;
            this.btnNotiDelete.Click += new System.EventHandler(this.btnNotiDelete_Click);
            // 
            // btnNotiUpdate
            // 
            this.btnNotiUpdate.Location = new System.Drawing.Point(113, 121);
            this.btnNotiUpdate.Name = "btnNotiUpdate";
            this.btnNotiUpdate.Size = new System.Drawing.Size(75, 23);
            this.btnNotiUpdate.TabIndex = 22;
            this.btnNotiUpdate.Text = "Update";
            this.btnNotiUpdate.UseVisualStyleBackColor = true;
            this.btnNotiUpdate.Click += new System.EventHandler(this.btnNotiUpdate_Click);
            // 
            // btnNotiAdd
            // 
            this.btnNotiAdd.Location = new System.Drawing.Point(37, 121);
            this.btnNotiAdd.Name = "btnNotiAdd";
            this.btnNotiAdd.Size = new System.Drawing.Size(75, 23);
            this.btnNotiAdd.TabIndex = 21;
            this.btnNotiAdd.Text = "Add";
            this.btnNotiAdd.UseVisualStyleBackColor = true;
            this.btnNotiAdd.Click += new System.EventHandler(this.btnNotiAdd_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.rbtnRepeatTypeMonthly);
            this.groupBox1.Controls.Add(this.dgEvents);
            this.groupBox1.Controls.Add(this.rbtnRepeatTypeAnnually);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.rbtnRepeatTypeNo);
            this.groupBox1.Controls.Add(this.txtEventName);
            this.groupBox1.Controls.Add(this.label6);
            this.groupBox1.Controls.Add(this.tpEventTime);
            this.groupBox1.Controls.Add(this.label7);
            this.groupBox1.Controls.Add(this.btnEventDelete);
            this.groupBox1.Controls.Add(this.btnEventAdd);
            this.groupBox1.Controls.Add(this.btnEventUpdate);
            this.groupBox1.Location = new System.Drawing.Point(28, 209);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(292, 325);
            this.groupBox1.TabIndex = 24;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Event";
            // 
            // rbtnRepeatTypeMonthly
            // 
            this.rbtnRepeatTypeMonthly.AutoSize = true;
            this.rbtnRepeatTypeMonthly.Location = new System.Drawing.Point(127, 90);
            this.rbtnRepeatTypeMonthly.Name = "rbtnRepeatTypeMonthly";
            this.rbtnRepeatTypeMonthly.Size = new System.Drawing.Size(70, 19);
            this.rbtnRepeatTypeMonthly.TabIndex = 30;
            this.rbtnRepeatTypeMonthly.TabStop = true;
            this.rbtnRepeatTypeMonthly.Text = "Monthly";
            this.rbtnRepeatTypeMonthly.UseVisualStyleBackColor = true;
            // 
            // rbtnRepeatTypeAnnually
            // 
            this.rbtnRepeatTypeAnnually.AutoSize = true;
            this.rbtnRepeatTypeAnnually.Location = new System.Drawing.Point(203, 90);
            this.rbtnRepeatTypeAnnually.Name = "rbtnRepeatTypeAnnually";
            this.rbtnRepeatTypeAnnually.Size = new System.Drawing.Size(72, 19);
            this.rbtnRepeatTypeAnnually.TabIndex = 29;
            this.rbtnRepeatTypeAnnually.TabStop = true;
            this.rbtnRepeatTypeAnnually.Text = "Annually";
            this.rbtnRepeatTypeAnnually.UseVisualStyleBackColor = true;
            // 
            // rbtnRepeatTypeNo
            // 
            this.rbtnRepeatTypeNo.AutoSize = true;
            this.rbtnRepeatTypeNo.Location = new System.Drawing.Point(80, 90);
            this.rbtnRepeatTypeNo.Name = "rbtnRepeatTypeNo";
            this.rbtnRepeatTypeNo.Size = new System.Drawing.Size(41, 19);
            this.rbtnRepeatTypeNo.TabIndex = 28;
            this.rbtnRepeatTypeNo.TabStop = true;
            this.rbtnRepeatTypeNo.Text = "No";
            this.rbtnRepeatTypeNo.UseVisualStyleBackColor = true;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(31, 92);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(43, 15);
            this.label6.TabIndex = 27;
            this.label6.Text = "Repeat";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.dgNotis);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.btnNotiDelete);
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Controls.Add(this.btnNotiUpdate);
            this.groupBox2.Controls.Add(this.label4);
            this.groupBox2.Controls.Add(this.btnNotiAdd);
            this.groupBox2.Controls.Add(this.label5);
            this.groupBox2.Controls.Add(this.nmMinutes);
            this.groupBox2.Controls.Add(this.nmDays);
            this.groupBox2.Controls.Add(this.nmHours);
            this.groupBox2.Location = new System.Drawing.Point(349, 209);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(299, 325);
            this.groupBox2.TabIndex = 25;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Notification";
            // 
            // timer
            // 
            this.timer.Enabled = true;
            this.timer.Interval = 60000;
            this.timer.Tick += new System.EventHandler(this.timer_Tick);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(678, 555);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.calendar);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgEvents)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgNotis)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nmDays)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nmHours)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nmMinutes)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private MonthCalendar calendar;
        private DataGridView dgEvents;
        private Label label1;
        private TextBox txtEventName;
        private DataGridView dgNotis;
        private Label label2;
        private Label label3;
        private Label label4;
        private DateTimePicker tpEventTime;
        private Label label5;
        private NumericUpDown nmDays;
        private NumericUpDown nmHours;
        private NumericUpDown nmMinutes;
        private Label label7;
        private Button btnEventAdd;
        private Button btnEventUpdate;
        private Button btnEventDelete;
        private Button btnNotiDelete;
        private Button btnNotiUpdate;
        private Button btnNotiAdd;
        private GroupBox groupBox1;
        private GroupBox groupBox2;
        private System.Windows.Forms.Timer timer;
        private RadioButton rbtnRepeatTypeMonthly;
        private RadioButton rbtnRepeatTypeAnnually;
        private RadioButton rbtnRepeatTypeNo;
        private Label label6;
    }
}