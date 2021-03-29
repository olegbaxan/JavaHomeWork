import { Component, OnInit } from '@angular/core';
import {PersonService} from '../../services/person.service';
import {FormGroup, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-add-person',
  templateUrl: './add-person.component.html',
  styleUrls: ['./add-person.component.css']
})
export class AddPersonComponent implements OnInit {

  title="Add person form";
  name;
  surname;
  description;
  phone;
  mobile;
  email;
  regdate;
  idnp;
  birthday;
  formdata:FormGroup;

  constructor(private personService: PersonService) { }

  ngOnInit(): void {
   this.regdate= this.personService.showTodayDate()
    this.formdata = new FormGroup({
      name: new FormControl("",Validators.required),
      surname: new FormControl("",Validators.required),
      description: new FormControl(""),
      phone: new FormControl(""),
      mobile: new FormControl(""),
      email: new FormControl("",Validators.required),
      idnp: new FormControl("",Validators.required),
      birthday: new FormControl(""),
    });
  }
  createPerson(data) {
    this.personService.createPerson(data)
      .subscribe(()=>{
        this.name = data.name;
        this.surname = data.surname;
        this.description = data.description;
        this.phone = data.phone;
        this.mobile = data.mobile;
        this.email = data.email;
        this.regdate = data.regdate;
        this.idnp = data.idnp;
        this.birthday = data.birthday;}
        ,(error) => {
          console.error(error);
        }
        );
    setTimeout(()=>{
      this.formdata.reset();
    }, 1000);
    //
  }

}
