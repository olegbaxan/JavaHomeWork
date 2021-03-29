import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListPersonComponent} from './components/list-person/list-person.component';
import {AddPersonComponent} from './components/add-person/add-person.component';
import {EditPersonComponent} from './components/edit-person/edit-person.component';

const routes: Routes = [
  {path: 'person', component: ListPersonComponent },
  {path: 'add', component: AddPersonComponent },
  {path: 'person/:id', component: EditPersonComponent},
  {path: '', redirectTo: 'person', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  data: any;
}

