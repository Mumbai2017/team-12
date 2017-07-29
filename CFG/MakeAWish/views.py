from django.http import HttpResponse
from django.shortcuts import render
from MakeAWish.models import ChildProfile, Doctor, Volunteer, Donor, Transaction


# Create your views here.

def admin_panel(request):
    return render(request, '/MakeAWish/index.html', {})
