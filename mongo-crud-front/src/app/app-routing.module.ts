import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './product/list.component';
import { DetailComponent } from './product/detail.component';
import { CreateComponent } from './product/create.component';
import { UpdateComponent } from './product/update.component';




const routes:Routes = [
  {path: '', component:ListComponent},
  {path: 'detail', component:DetailComponent},
  {path: 'create', component:CreateComponent},
  {path: 'update', component:UpdateComponent},
  {path: '**', redirectTo:'',pathMatch:'full'}
];

@NgModule({
  imports:[RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutingModule { }




