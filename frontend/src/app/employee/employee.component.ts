import { Component, OnInit } from '@angular/core';
import { Employee } from './employee.model';
import { NgForm } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],
})
export class EmployeeComponent implements OnInit {
  employee: Employee = {
    employeeId: 0,
    employeeName: '',
    employeeContactNumber: '',
    employeeAddress: '',
    employeeGender: '',
    employeeDepartment: '',
    employeeSkills: '',
  };

  skills: string[] = [];

  constructor(private employeeService: EmployeeService) {}
  ngOnInit(): void {}

  saveEmployee(employeeForm: NgForm): void {
    this.employeeService.saveEmployee(this.employee).subscribe({
      next: (res: Employee) => {
        console.log(res);
        employeeForm.reset();
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      }
    });
  }

  selectGender(gender: string): void {
    this.employee.employeeGender = gender;
  }

  onSkillsChanges(event: any): void {
    if (event.checked) {
      this.skills.push(event.source.value);
    } else {
      this.skills.forEach((item, index) => {
        if (item == event.source.value) {
          this.skills.splice(index, 1);
        }
      });
    }

    this.employee.employeeSkills = this.skills.toString();
  }
}
