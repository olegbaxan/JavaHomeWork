import {Component, Injectable, OnInit, Output} from '@angular/core';
import {PersonService} from '../../services/person.service';
import {HeaderComponent} from '../header/header.component';
import {EditPersonComponent} from '../edit-person/edit-person.component'



@Component({
  selector: 'app-list-person',
  templateUrl: './list-person.component.html',
  styleUrls: ['./list-person.component.css']
})
@Injectable({providedIn:EditPersonComponent})
export class ListPersonComponent implements OnInit {

  persons: any
  selectedUser=null;
  currentIndex=-1;
  query='';

  constructor(private personService: PersonService) {
  }

  ngOnInit(): void {
    this.retrievePersons();
  }


  retrievePersons(): void {
    this.personService.getAll()
      .subscribe((data) => {
          this.persons = data;
          console.log(data);
        },
        (error) => {
          console.error(error);
        });
  }

  refreshList(): void {
    this.retrievePersons();
    this.selectedUser = null;
    this.currentIndex = -1;
  }

  selectEmployee(employee, index): void {
    this.selectedUser = employee;
    this.currentIndex = index;
  }


  searchByName(): void {
    this.personService.getById(this.query)
      .subscribe(
        data => {
          this.persons = [data];
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  deletePerson(id:number){
    this.personService.deletePerson(id)
      .subscribe( () => { this.persons.splice(id, 1);}
        ,(error) => {
          console.error(error);
        });
  }

}
