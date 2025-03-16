import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, RouterLink } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-court-list-page',
  standalone: true,
  templateUrl: './court-list-page.component.html',
  styleUrls: ['./court-list-page.component.css'],
  imports: [NgFor, NgIf, RouterLink, FormsModule]
})
export class CourtListPageComponent implements OnInit {
  courts: any[] = [];
  searchQuery: string = '';
  userId: string | null = localStorage.getItem("userId");

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:8080/courts').subscribe({
      next: (response) => {
        this.courts = response;
      },
      error: (error) => {
        console.error('Ошибка загрузки кортов:', error);
      }
    });
  }

  get filteredCourts() {
    return this.courts.filter(court =>
      court.courtTypeName.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
      court.cityName.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
      court.courtAddress.toLowerCase().includes(this.searchQuery.toLowerCase())
    );
  }
}
