import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../../services/employee.service';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  employees: any;

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.retrieveEmployees();
  }

  retrieveEmployees(): void {
    this.employeeService.getAll()
      .subscribe((data) => {
          this.employees = data;
          console.log(data);
        },
        (error) => {
          console.error(error);
        });
  }

}
