import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-court-detail-page',
  standalone: true,
  templateUrl: './court-detail-page.component.html',
  styleUrls: ['./court-detail-page.component.css'],
  imports: [NgFor, NgIf, FormsModule]
})
export class CourtDetailPageComponent implements OnInit {
  courtId!: string;
  court: any = null;
  arrivals: any[] = [];
  reviews: any[] = [];
  reviewText: string = '';
  date: string = '';
  startTime: string = '';
  endTime: string = '';
  userId: string | null = localStorage.getItem('userId');

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.courtId = this.route.snapshot.paramMap.get('courtId')!;
    this.loadCourtDetails();
  }

  loadCourtDetails() {
    this.http.get<any>(`http://localhost:8080/court/${this.courtId}`).subscribe({
      next: (courtData) => {
        this.court = courtData;
        this.loadArrivalsAndReviews();
      },
      error: (error) => console.error('Ошибка загрузки данных корта:', error)
    });
  }

  loadArrivalsAndReviews() {
    this.http.get<any[]>(`http://localhost:8080/court/${this.courtId}/arrivals`).subscribe({
      next: (data) => (this.arrivals = data),
      error: (error) => console.error('Ошибка загрузки записей:', error)
    });

    this.http.get<any[]>(`http://localhost:8080/court/${this.courtId}/reviews`).subscribe({
      next: (data) => (this.reviews = data),
      error: (error) => console.error('Ошибка загрузки комментариев:', error)
    });
  }

  handleArrivalSubmit() {
    if (!this.userId) {
      alert('Ошибка: пользователь не найден.');
      return;
    }

    const payload = {
      userId: this.userId,
      date: this.date,
      startTime: this.startTime,
      endTime: this.endTime
    };

    this.http.post(`http://localhost:8080/court/${this.courtId}/arrivals`, payload).subscribe({
      next: () => {
        alert('Вы успешно записались на игру!');
        this.loadArrivalsAndReviews(); // Перезагрузка списка
      },
      error: (err) => {
        console.error('Ошибка при записи:', err);
        alert('Произошла ошибка при записи.');
      }
    });
  }

  handleReviewSubmit() {
    if (!this.userId) {
      alert('Ошибка: пользователь не найден.');
      return;
    }

    const payload = { userId: this.userId, text: this.reviewText };

    this.http.post(`http://localhost:8080/court/${this.courtId}/reviews`, payload).subscribe({
      next: () => {
        this.reviewText = '';
        alert('Комментарий добавлен!');
        this.loadArrivalsAndReviews();
      },
      error: (err) => {
        console.error('Ошибка при добавлении комментария:', err);
        console.log(err);
        alert('Произошла ошибка при добавлении комментария.');
      }
    });
  }

  navigateBack() {
    this.router.navigate(['/courts']);
  }
}
