import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactosAddComponent, ContactosEditComponent, ContactosListComponent, ContactosViewComponent } from './contactos/componente.component';
import { DemosComponent } from './demos/demos.component';
import { HomeComponent, PageNotFoundComponent } from './main';
import { CalculadoraComponent } from './main/calculadora/calculadora.component';

const routes: Routes = [
  { path: ''                        , pathMatch    : 'full', component: HomeComponent                                    },
  { path: 'inicio'                  , component    : HomeComponent                                                       },
  { path: 'demos'                   , component    : DemosComponent                                                      },
  { path: 'chisme/de/hacer/numeros' , component    : CalculadoraComponent                                                },
  { path: 'contactos/:id/add'       , component    : ContactosAddComponent                                               },
  { path: 'contactos/:id/edit'      , component    : ContactosEditComponent                                              },
  { path: 'contactos/:id/:kk'       , component    : ContactosViewComponent                                              },
  { path: 'contactos/:id'           , component    : ContactosViewComponent                                              },
  { path: 'contactos'               , component    : ContactosListComponent                                              },
  { path: 'alisha/passion'          , redirectTo   : '/contactos/9'                                                      },
  { path: 'config'                  , loadChildren : () => import('./config/config.module').then(mod => mod.ConfigModule)},
  { path: '404.html'                , component    : PageNotFoundComponent                                               },
  { path: '**'                      , component    : HomeComponent                                                       },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
