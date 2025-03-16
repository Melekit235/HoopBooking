import { Component, OnInit, inject } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-player-profile-page',
  standalone: true,  // Позволяет использовать импорты без модуля
  templateUrl: './player-profile-page.component.html',
  styleUrls: ['./player-profile-page.component.css'],
  imports: [CommonModule] // Добавляем поддержку *ngIf и *ngFor
})
export class PlayerProfilePageComponent implements OnInit {
  user: any = null;
  friends: any[] = [];
  favoriteCourts: any[] = [];

  private http = inject(HttpClient);
  private router = inject(Router);

  ngOnInit(): void {
    const userId = localStorage.getItem("userId");

    if (!userId) {
      console.error("User ID is not found in localStorage");
      this.router.navigate(['/login']);
      return;
    }

    this.fetchUserData(userId);
  }

  fetchUserData(userId: string): void {
    this.http.get(`http://localhost:8080/profile/${userId}`).subscribe({
      next: (userData: any) => {
        this.user = userData;

        this.http.get(`http://localhost:8080/profile/friends/${userId}`).subscribe({
          next: (friendsData: any) => this.friends = friendsData
        });

        this.http.get(`http://localhost:8080/profile/favorites/${userId}`).subscribe({
          next: (courtsData: any) => this.favoriteCourts = courtsData
        });
      },
      error: (err) => console.error("Error fetching user data", err)
    });
  }

  handleLogout(): void {
    localStorage.removeItem("userId");
    this.router.navigate(['/login']);
  }

  handleBackToCourts(): void {
    this.router.navigate(['/courts']);
  }
}
