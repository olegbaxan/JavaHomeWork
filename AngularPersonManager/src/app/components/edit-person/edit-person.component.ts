import {Component,  OnInit} from '@angular/core';
// import {FormControl, FormGroup, Validators} from '@angular/forms';
import {PersonService} from '../../services/person.service';
import {ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-edit-person',
  templateUrl: './edit-person.component.html',
  styleUrls: ['./edit-person.component.css']
})
export class EditPersonComponent implements OnInit {

  title="Edit person form";
  person=null;
  message = '';
  constructor(
    private personService: PersonService,
    private route: ActivatedRoute,
    // private router: Router,
  ) {  }

  ngOnInit(): void {
    this.message = '';
    this.getPersonById(this.route.snapshot.paramMap.get('id'));
  }
  getPersonById(id):void {
    this.personService.getById(id)
      .subscribe(
        data => {
          this.person = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  updatePerson(): void {
    this.personService.editPerson(this.person.id, this.person)
      .subscribe(
        response => {
          console.log(response);
          this.message = 'The person was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }
  updatePublished(status): void {
    const data = {
      title: this.person.title,
      description: this.person.description,
      published: status
    };

    this.personService.editPerson(this.person.id, data)
      .subscribe(
        response => {
          this.person.published = status;
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }
  //         this.formdata = new FormGroup({
  //           // personId:new FormControl({value: this.person.personId, disabled: true}, Validators.required),
  //           personId: new FormControl(this.person.personId),
  //           name: new FormControl(this.person.name),
  //           surname: new FormControl(this.person.surname),
  //           description: new FormControl(this.person.description),
  //           phone: new FormControl(this.person.phone),
  //           mobile: new FormControl(this.person.mobile),
  //           email: new FormControl(this.person.email),
  //           idnp: new FormControl(this.person.idnp),
  //           birthday: new FormControl(this.person.birthday),
  //         }),
  //       (error) => {
  //         console.error(error);
  //       };
  // }

  // editPersonData(data){
  //   this.personService.editPerson(data).subscribe(()=>{
  //           this.personId=this.person.personId;
  //           this.surname = data.surname;
  //             this.description = data.description;
  //             this.phone = data.phone;
  //             this.mobile = data.mobile;
  //             this.email = data.email;
  //             this.regdate = this.person.regdate;
  //             this.idnp = data.idnp;
  //             this.birthday = data.birthday;
  //   })

  // }

  //  editPersonData(data: any) {
  //   this.personService.editPerson(this.id,data)
  //     .subscribe(()=>{
  //       this.personId=data.personId;
  //         this.name = data.name;
  //         this.surname = data.surname;
  //         this.description = data.description;
  //         this.phone = data.phone;
  //         this.mobile = data.mobile;
  //         this.email = data.email;
  //         this.regdate = this.person.regdate;
  //         this.idnp = data.idnp;
  //         this.birthday = data.birthday;
  //       }
  //       ,(error) => {
  //         console.error(error);
  //       }
  //     );
  //   setTimeout(()=>{
  //     this.formdata.reset();
  //   }, 1000);
  // }

}
