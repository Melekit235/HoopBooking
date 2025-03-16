import { Routes } from '@angular/router';

import { LoginPageComponent } from './pages/login-page/login-page.component';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { PlayerProfilePageComponent } from './pages/player-profile-page/player-profile-page.component';
import { CourtListPageComponent } from './pages/court-list-page/court-list-page.component';
import { CourtDetailPageComponent } from './pages/court-detail-page/court-detail-page.component';

export const routes: Routes = [
  { path: '', component: LoginPageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'register', component: RegisterPageComponent },
  { path: 'profile/:userId', component: PlayerProfilePageComponent },
  { path: 'courts', component: CourtListPageComponent },
  { path: 'court/:courtId', component: CourtDetailPageComponent },
];