from django.shortcuts import render, get_object_or_404
from .models import BlogPost

# Create your views here.

def index(request):
    posts = BlogPost.objects.all()
    return render(request, 'blog/index.html', {'posts': posts})

def view_post(request, id):
    post = get_object_or_404(BlogPost, pk=id)
    return render(request, 'blog/view.html', {'post': post})

